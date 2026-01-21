// Types
type Item = {
    id: number,
    displayName: string,
    listPriceBeforeTax: number,
    taxExempt: boolean
}

type PriceList = Item[]

type TaxRule = {
    vatPercentage: number
    effectiveDate: Date
}

type TaxRules = TaxRule[]

type DiscountRules = {
    percentageDiscount: number,
    bulkDiscount: {
        itemId: number,
        minItems: number,
        discountPerItem: number
    }
}

type CartItem = {
    itemId: number,
    quantity: number
}

type ShoppingCart = {
    salesDate: Date,
    items: CartItem[]
}

type InvoiceLineItem = {
    item: Item,
    quantity: number,
    bulkDiscountApplied: number,
    totalAfterDiscount: number,
    totalAfterDiscountAfterTax: number
}

type Invoice = {
    items: InvoiceLineItem[],
    invoiceDate: Date,
    totalVatAdded: number,
    invoiceTotalBeforeTax: number,
    invoiceTotalAfterTax: number,
}

// Helper functions
const findItemById = (priceList: PriceList, itemId: number): Item =>
    priceList.find(item => item.id === itemId)!

const findTaxRule = (taxRules: TaxRules, salesDate: Date): TaxRule =>
    taxRules
        .filter(rule => rule.effectiveDate <= salesDate)
        .reduce((latest, current) =>
            current.effectiveDate > latest.effectiveDate ? current : latest
        )

const calculatePercentageDiscount = (price: number, discountRules: DiscountRules): number =>
    price * (discountRules.percentageDiscount / 100)

const calculateBulkDiscount = (
    cartItem: CartItem,
    discountRules: DiscountRules,
    priceList: PriceList
): number => {
    const isBulkEligible = cartItem.itemId === discountRules.bulkDiscount.itemId &&
                          cartItem.quantity >= discountRules.bulkDiscount.minItems

    return isBulkEligible
        ? cartItem.quantity * discountRules.bulkDiscount.discountPerItem
        : 0
}

const calculateLineItemTotalBeforeDiscount = (item: Item, quantity: number): number =>
    item.listPriceBeforeTax * quantity

const calculateLineItemTotalAfterDiscount = (
    totalBeforeDiscount: number,
    percentageDiscount: number,
    bulkDiscount: number
): number => {
    const afterPercentageDiscount = totalBeforeDiscount - percentageDiscount
    return afterPercentageDiscount - bulkDiscount
}

const calculateLineItemTax = (
    totalAfterDiscount: number,
    vatPercentage: number,
    isTaxExempt: boolean
): number =>
    isTaxExempt ? 0 : totalAfterDiscount * (vatPercentage / 100)

const calculateLineItemTotalAfterTax = (
    totalAfterDiscount: number,
    taxAmount: number
): number => totalAfterDiscount + taxAmount

const createInvoiceLineItem = (
    cartItem: CartItem,
    item: Item,
    discountRules: DiscountRules,
    vatPercentage: number
): InvoiceLineItem => {
    const totalBeforeDiscount = calculateLineItemTotalBeforeDiscount(item, cartItem.quantity)
    const percentageDiscount = calculatePercentageDiscount(totalBeforeDiscount, discountRules)
    const bulkDiscount = calculateBulkDiscount(cartItem, discountRules, [item]) // Pass item as array for consistency
    const totalAfterDiscount = calculateLineItemTotalAfterDiscount(
        totalBeforeDiscount,
        percentageDiscount,
        bulkDiscount
    )
    const taxAmount = calculateLineItemTax(totalAfterDiscount, vatPercentage, item.taxExempt)
    const totalAfterTax = calculateLineItemTotalAfterTax(totalAfterDiscount, taxAmount)

    return {
        item,
        quantity: cartItem.quantity,
        bulkDiscountApplied: bulkDiscount,
        totalAfterDiscount,
        totalAfterDiscountAfterTax: totalAfterTax
    }
}

// Main function
function prepareCartInvoice(
    priceList: PriceList,
    taxRules: TaxRules,
    discounts: DiscountRules,
    cart: ShoppingCart
): Invoice {

    const activeTaxRule = findTaxRule(taxRules, cart.salesDate)
    const vatPercentage = activeTaxRule.vatPercentage

    const invoiceLineItems = cart.items
        .map(cartItem => {
            const item = findItemById(priceList, cartItem.itemId)
            return createInvoiceLineItem(cartItem, item, discounts, vatPercentage)
        })

    const calculateTotals = (invoiceItems: InvoiceLineItem[]) => ({
        totalBeforeTax: invoiceItems.reduce((sum, line) => sum + line.totalAfterDiscount, 0),
        totalAfterTax: invoiceItems.reduce((sum, line) => sum + line.totalAfterDiscountAfterTax, 0),
        totalVat: invoiceItems.reduce((sum, line) =>
            sum + (line.totalAfterDiscountAfterTax - line.totalAfterDiscount), 0
        )
    })

    const totals = calculateTotals(invoiceLineItems)

    return {
        items: invoiceLineItems,
        invoiceDate: cart.salesDate,
        totalVatAdded: totals.totalVat,
        invoiceTotalBeforeTax: totals.totalBeforeTax,
        invoiceTotalAfterTax: totals.totalAfterTax,
    }
}

// Example usage
const priceList: PriceList = [
    { id: 1, displayName: "Laptop", listPriceBeforeTax: 1000, taxExempt: false },
    { id: 2, displayName: "Book", listPriceBeforeTax: 20, taxExempt: true },
    { id: 3, displayName: "Pen", listPriceBeforeTax: 5, taxExempt: false }
]

const taxRules: TaxRules = [
    { vatPercentage: 15, effectiveDate: new Date("2024-01-01") },
    { vatPercentage: 20, effectiveDate: new Date("2024-06-01") }
]

const discounts: DiscountRules = {
    percentageDiscount: 10,
    bulkDiscount: {
        itemId: 3,
        minItems: 10,
        discountPerItem: 0.5
    }
}

const cart: ShoppingCart = {
    salesDate: new Date("2024-07-01"),
    items: [
        { itemId: 1, quantity: 1 },
        { itemId: 2, quantity: 3 },
        { itemId: 3, quantity: 15 }
    ]
}

const invoice = prepareCartInvoice(priceList, taxRules, discounts, cart)
console.log(invoice)