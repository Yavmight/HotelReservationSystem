public interface Reservable {
    boolean isAvailable();
    void reserve();
    void release();
}
