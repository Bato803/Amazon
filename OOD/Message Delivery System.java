public class MessageDeliverySystem {


    public static void main(String[] args) {


        Phone phone = new Phone();
        Windows windows = new Windows();


        Message message = new Message();

        message.addObserver(phone);
        message.addObserver(windows);

        message.generateMessage();


    }


    interface Observer {

        public void update(int message);
    }

    interface ObserveAble {


        public void addObserver(Observer observer);

        public void removeObserve(Observer observe);


        public void notifyAllObserve();
    }


    static class Message implements ObserveAble {

        int message;

        private volatile int count = 10;

        List<Observer> observerList = new ArrayList<>();

        @Override
        public void addObserver(Observer observer) {

            observerList.add(observer);

        }

        @Override
        public void removeObserve(Observer observe) {

        }

        @Override
        public void notifyAllObserve() {

            for (Observer observer : observerList) {
                observer.update(message);
            }


        }

        public void generateMessage() {

            Thread thread = new Thread(() -> {


                while (count > 0) {
                    count--;
                    message = new Random().nextInt(100);
                    notifyAllObserve();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            });
            thread.run();


        }


    }

    static class Phone implements Observer {

        @Override
        public void update(int message) {
            System.out.println("Phone: " + message);
        }
    }


    static class Windows implements Observer {

        @Override
        public void update(int message) {
            System.out.println("Windows: " + message);
        }
    }
}
