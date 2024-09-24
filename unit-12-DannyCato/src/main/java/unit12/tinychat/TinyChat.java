package unit12.tinychat;

public interface TinyChat {
    public void quit();
    public void connect(String name);
    public void sendMessage(String name, String message);
}