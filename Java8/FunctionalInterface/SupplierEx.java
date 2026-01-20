package Java8.FunctionalInterface;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierEx {
    public static void main(String[] args) {

        //supplies data to the calling function


        Supplier<LocalDateTime> dateTime = new SupplierImp();
        System.out.println(dateTime.get());
    }
}

class SupplierImp implements Supplier<LocalDateTime>{

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }
}

