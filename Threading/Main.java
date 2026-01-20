import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public  class Main{
    public static void main(String[] args) {

    /*
     A thread is a process within a process
     A process is a program in execution
        while program is a piece or code, software artifact.
        scheduling algos



     */

        //executors - task managers that helps with running tasks.
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(()-> System.out.println("Task"));

        //Executors replaces manual threads management
        Thread thread = new Thread(()-> System.out.println("Task"));
        thread.start();

        /*
            Single Thread Executor
        *   Executors.newSingleThreadExecutor()
        Has only 1 thread
        Tasks execute one after another
        useful for sequential tasks that need to be in order

        *
        */

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        /*
        * has fixed number of threads
        * tasks are queued if all threads are busy
        * like having 3 bank tellers serving customers
        *
         */

        ExecutorService executorService1 = Executors.newCachedThreadPool();

        //Cached Thread Pool
        /*
            Creates threads as needed, reuses idle ones
            good for many short-lived tasks
            can grow/shrink automatically
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        /*
        Can schedule tasks to run after a delay, at fixed intervals, like a timer or cron job
         */


        //NOT YET IMPLEMENTED IN JAVA - PROJECT LOOM
//        Continuation cont = new Continuation(scope -> {
//            System.out.println("step 1");
//            Continuation.yield(scope);
//            //pause here
//            System.out.println("step 1");
//            Continuation.yield(scope);
//            //pause again
//        }) ;
//        cont.run();
//        cont.run();


    }
}