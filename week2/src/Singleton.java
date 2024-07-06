class Device {
    private String name;
    private int volume;

    public Device(String name) {
        this.name = name;
        this.volume = 0;
    }

    public void turnOn() {
        System.out.println(name + " is turned on");
    }

    public void turnOff() {
        System.out.println(name + " is turned off");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(name + " volume set to " + volume);
    }

    public int getVolume() {
        return volume;
    }
}

class RemoteControl {
    private static RemoteControl instance;

    private Device device;

    private RemoteControl() { }

    public static RemoteControl getInstance() {
        if (instance == null) {
            instance = new RemoteControl();
        }
        return instance;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void turnOnDevice() {
        if (device != null) {
            device.turnOn();
        }
    }

    public void turnOffDevice() {
        if (device != null) {
            device.turnOff();
        }
    }

    public void setVolume(int volume) {
        if (device != null) {
            device.setVolume(volume);
        }
    }

    public int getVolume() {
        if (device != null) {
            return device.getVolume();
        }
        return 0;
    }
}

public class Singleton {
    public static void main(String[] args) {
        RemoteControl remote = RemoteControl.getInstance();

        Device tv = new Device("TV");
        remote.setDevice(tv);

        remote.turnOnDevice();
        remote.setVolume(50);
        System.out.println("TV volume: " + remote.getVolume());

        remote.turnOffDevice();
    }
}
