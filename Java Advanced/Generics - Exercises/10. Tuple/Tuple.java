package Jar;


    public class Tuple<item1,item2> {
        private item1 item1;
        private item2 item2;

        public Tuple(item1 item1, item2 item2) {
            this.item1 = item1;
            this.item2 = item2;
        }

        @Override
        public String toString() {
            return String.format("%s -> %s",this.item1,this.item2);
        }
}
