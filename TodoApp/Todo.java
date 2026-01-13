package TodoApp;

public class Todo
{

    private int id;
    private String item;
    private boolean done;


    public Todo(int id,String item, boolean done){
        setId(id);
        setItem(item);
        setDone(done);
    }

    public Todo(int id,String item)
    {
        setId(id);
        setItem(item);

    }

    //getters

    public int getId(){
        return this.id;
    }
    public String getItem(){
        return this.item;
    }

    public boolean getDone(){
        return this.done;
    }
    // and setters

    public void setId(int id){
        this.id = id;
    }
    public void setItem(String item){
        this.item = item;
    }

    public void setDone(boolean done){
        this.done = done;
    }

    @Override
    public String toString(){
        return  this.id + "\n" +
                this.item + "\n" +
                this.done;
    }

}