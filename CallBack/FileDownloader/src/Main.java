class FileDownloader {
    interface CallBack {
        void esperar (int percentage);
    }

    public void downloadFile(String filePath, CallBack callBack) {
        for (int percentage = 0; percentage <= 100; percentage += 10) {
            callBack.esperar(percentage);
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        }
        System.out.println("Has descargado al completo el Archivo");
    }
}

class Archivo implements FileDownloader.CallBack{

    @Override
    public void esperar(int percentage) {
        System.out.println("Descargando el Archivo: "+percentage);
    }
}

public class Main {
    public static void main(String[] args) {
        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.downloadFile("http://.../myFile.txt", new Archivo());
    }
}