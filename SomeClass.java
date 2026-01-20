public class SomeClass<T>
{
    private T t;

    public SomeClass(T t){
        this.t = t;
    }
    public void set(T t){
        this.t =t;
    }

    public T get(){
        return this.t;
    }



}