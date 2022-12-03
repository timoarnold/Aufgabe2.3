public class ThreadUtil {

    /**
     * Die sleep Methode lässt den Thread um die Zeit zeit schlafen
     *
     * @param zeit: Anzahl Millisekunden, welche der Thread schläfen soll.
     */
    public static void sleep(int zeit) {
        try {
            Thread.sleep(zeit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Die Synchronisierungsmethode syncedPrintIn stellt sicher, dass nur ein Thread zeitgleich auf die Systemressource zugreift.
     * dass nur ein Thread zu einem bestimmten Zeitpunkt auf die Ressource zugreifen kann.
     *
     * @param message: String Nachricht, welche gedruckt werden soll.
     */
    public static void syncedPrintln(String message) {
        synchronized (System.out) {
            System.out.println(message);
        }
    }
}
