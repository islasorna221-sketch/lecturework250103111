package LectureWork;

public class ThermostatAdapter implements SmartDevice {
    private final LegacyThermostat thermostat;

    public ThermostatAdapter(LegacyThermostat thermostat) {
        if (thermostat == null) {
            throw new IllegalArgumentException("Thermostat cannot be null");
        }
        this.thermostat = thermostat;
    }

    @Override
    public void turnOn() {
        String dial = thermostat.checkDial();
        if ("IDLE".equals(dial)) {
            thermostat.rotateDial("LOW");
        }
    }

    @Override
    public void turnOff() {
        thermostat.rotateDial("IDLE");
    }

    @Override
    public boolean isOn() {
        String dial = thermostat.checkDial();
        if (dial == null) return false;

        return "LOW".equals(dial) || "MEDIUM".equals(dial) || "MAX".equals(dial);
    }

    @Override
    public int getPowerPercent() {
        String dial = thermostat.checkDial();
        if (dial == null) return -1;
        switch (dial) {
            case "IDLE":
                return 0;
            case "LOW":
                return 33;
            case "MEDIUM":
                return 66;
            case "MAX":
                return 100;
            default:
                // Stage 4: Для поврежденных/неизвестных состояний
                return -1;
        }
    }
}
