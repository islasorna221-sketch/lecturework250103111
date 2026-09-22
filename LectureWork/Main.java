package LectureWork;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("OMNIHOME SMART CONTROLLER: SYSTEM STARTUP");
        System.out.println("=========================================");

        LegacyBulb rawBulb = new LegacyBulb();
        LegacyThermostat rawThermostat = new LegacyThermostat();

        BulbAdapter bulbAdapter = new BulbAdapter(rawBulb);
        ThermostatAdapter thermostatAdapter = new ThermostatAdapter(rawThermostat);

        // ModernHub badHub = new ModernHub(List.of(rawBulb));

        List<SmartDevice> deviceList = List.of(bulbAdapter, thermostatAdapter);
        ModernHub hub = new ModernHub(deviceList);

        System.out.println("\n--- OPERATION: ACTIVATE ALL DEVICES ---");
        hub.activateAll();
        System.out.println("Fleet Average Power Usage: " + hub.calculateAveragePowerUsage() + "%");

        System.out.println("\n--- AUDIT: HARDWARE FAULT INJECTION (STAGE 4) ---");

        rawBulb.breakFilament();
        System.out.println("Bulb isOn after filament break: " + bulbAdapter.isOn() + " [Expected: false]");
        System.out.println("Bulb Power %: " + bulbAdapter.getPowerPercent() + "% [Expected: 0%]");

        rawThermostat.rotateDial("STUCK");
        System.out.println("Thermostat isOn on STUCK: " + thermostatAdapter.isOn() + " [Expected: false]");
        System.out.println("Thermostat Power %: " + thermostatAdapter.getPowerPercent() + " [Expected: -1]");

        System.out.println("\n--- OPERATION: EMERGENCY SHUTDOWN ---");
        hub.emergencyShutdown();
        System.out.println("Fleet Average Power Usage: " + hub.calculateAveragePowerUsage() + "%");
    }
}