import Classes.MyList;


public class Main {
   
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.AddBegin(5);
        myList.AddBegin(4);
        myList.AddBegin(3);
        myList.AddBegin(2);
        myList.AddEnd(1);


        try {
            myList.AddBefore(999, 2);

            myList.RemoveByValue(999);
       

            myList.RemoveByIndex(2);


            myList.Clear();
        }
        catch (Exception e) {
        }

        myList.AddEnd(1);
    }
}
