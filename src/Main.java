public class Main {

    public static void main(String[] args) {
        W220Class w220 = new W220Class();
        W380Class w380 = new W380Class();
        adapterCharge adapterCharge = new adapterCharge(w380);
        adapterCharge.charger();
    }

    interface W380{
        void charger380w();
    }

    interface W220{
        void charger220w();
    }
    static class W380Class implements W380{
        @Override
        public void charger380w() {
            System.out.println("380w");
        }
    }
    static class W220Class implements W220{
        @Override
        public void charger220w() {
            System.out.println("220w");
        }
    }
    static class adapterCharge implements W220 {
        private W380 charge;
        public adapterCharge( W380Class charge){
            this.charge = charge;
        }
        public void charger(){
            charge.charger380w();
        }
        @Override
        public void charger220w() {
            System.out.println("Зарядка 220w");
        }
    }
}