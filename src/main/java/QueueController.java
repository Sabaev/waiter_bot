public class QueueController implements Runnable {

    QueueController(){
        Thread thread;
        thread = new Thread(this);
        thread.start();
    }

    int getQueueSize(){
        return queueSize;
    }

    @Override
    public void run() {
        ////todo need to sleep
        long time = 1000000000;
        while (true){
            long i = time;
            while (i != 0){
                --i;
            }
            if(queueSize != 0) {
                --queueSize;
            }
        }
    }


    int queueSize = 50;
}
