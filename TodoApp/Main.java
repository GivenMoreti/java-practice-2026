package TodoApp;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello world");

        HashSet<Todo> todos = new HashSet<>();

        String input = null;
        String item = null;
        int id;



        do{
            menu();

            System.out.println("Enter your decision: " );
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();


            switch (input)
            {
                case "1":
                    System.out.println("Adding a todo item: ");
                    Scanner itemScan = new Scanner(System.in);
                    item = itemScan.nextLine();
                    todos.add(new Todo(todos.size() + 1, item));

                    System.out.println("Loading please wait 😊");
                    Thread.sleep(2000);


                    printTodos(todos);

                    break;
                case "2":

                    System.out.println("Editing a todo item: ");
                    printTodos(todos);
                    System.out.println("Enter the id of a todo: ");
                    Scanner editScan = new Scanner(System.in);
                    id = editScan.nextInt();
                    editScan.nextLine();

                    Todo todoToEdit = null;

                    for(Todo todo: todos){
                        if(todo.getId() == id){
                            todoToEdit = todo;
                            break;
                        }
                    }

                    if(todoToEdit != null)
                    {
                        System.out.println("Current todo item " + todoToEdit.getItem());

                        System.out.println("Enter new todo item: ");
                        String newItem = editScan.nextLine();

                        System.out.print("Mark as done? y/n ");
                         String doneInput = editScan.nextLine();

                         boolean newDoneStatus = doneInput.equalsIgnoreCase("y");

                         todoToEdit.setItem(newItem);
                         todoToEdit.setDone(newDoneStatus);

                        System.out.println("Todo updated successfully!");
                        System.out.println("Loading please wait 😊");
                        Thread.sleep(2000);

                        printTodos(todos);
                    }
                    else
                    {
                        System.out.println(" todo with ID" + id +" not found");
                    }

                    break;
                case"3":

                    System.out.println("deleting a todo item: ");
                    printTodos(todos);
                    System.out.println("Enter the id of a todo to delete: ");

                    Scanner deleteScan = new Scanner(System.in);
                    id = deleteScan.nextInt();
                    deleteScan.nextLine();

                    Todo todoToDelete;
                    for(Todo todo: todos){
                        if(todo.getId() == id)
                        {

                            todoToDelete = todo;
                            todos.remove(todoToDelete);
                            break;
                        }
                        else
                        {
                            System.out.printf("id %s not found",id);
                        }

                    }

                    break;
                case "4":
                    printTodos(todos);
                    break;

                case "5":
                    System.out.println("Setting a todo item complete: ");
                    printTodos(todos);

                    Scanner completeTodoScan = new Scanner(System.in);
                    id = completeTodoScan.nextInt();
                    completeTodoScan.nextLine();

                    Todo todoToComplete = null;

                    for(Todo todo: todos)
                    {
                        if(todo.getId() == id)
                        {

                            todoToComplete = todo;
                            todoToComplete.setDone(true);
                            printTodos(todos);

                        }
                        else
                        {
                            System.out.println("todo with that id does not exist");
                        }
                    }

                    break;
                case "6":
                    //exit app
                    break;
                default:
                    System.out.println("enjoy your day!");
                    scan.close();

            }


        }
        while(!Objects.equals(input, "6"));
    }

    public static void menu()
    {
        System.out.println("Menu");
        System.out.println("1. add to do");
        System.out.println("2. edit todo ");
        System.out.println("3. delete todo ");
        System.out.println("4. print todos ");
        System.out.println("6. quit");
        System.out.println("5. set done");
    }

    public static void printTodos(HashSet<Todo> todoHash)
    {
        todoHash.forEach(t -> System.out.println(t.getId() + " " + t.getItem() + " " + t.getDone()));
    }
}