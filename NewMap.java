package test_map;

public class NewMap {

    MyEntry myEntry = new MyEntry(1, "first", new MyEntry(2, "second", new MyEntry(3, "third", new MyEntry(4, "fourth"))));

    public static class MyEntry {

        private int key;
        private String value;
        MyEntry next;


        public MyEntry(int key, String value, MyEntry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public MyEntry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public MyEntry() {
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public MyEntry getNext() {
            return next;
        }

        public void setNext(MyEntry next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyEntry myEntry = (MyEntry) o;

            if (key != myEntry.key) return false;
            if (value != null ? !value.equals(myEntry.value) : myEntry.value != null) return false;
            return next != null ? next.equals(myEntry.next) : myEntry.next == null;

        }

        @Override
        public int hashCode() {
            int result = key;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "KEY -> " + key + '\n' +
                    "VALUE -> " + value + '\n';
        }
    }

    public void remove(int key) {
        try {
            MyEntry previous = myEntry;
            MyEntry current = myEntry;

            while (current.key != key) {
                previous = current;
                current = current.next;
            }
            if (current == myEntry) {
                myEntry = myEntry.next;
            } else {
                previous.next = current.next;
            }
        } catch (RuntimeException e) {
            System.out.println("Not appropriate action.\nPlease, try one more time\n");
        }
    }

    public void print() {
        MyEntry temp = myEntry;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(myEntry);
    }
}