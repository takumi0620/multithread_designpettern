package m9_future;

public class Host {
    Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        final FutureData future = new FutureData();

        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(count, c);
                future.setRealData(realData);
            }
        }.start();

        System.out.println("    request(" + count + ", " + c + ") END");
        return future;
    }
}
