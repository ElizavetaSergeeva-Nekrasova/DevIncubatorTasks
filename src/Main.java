public class Main {
    public static void main(String[] args) {
        MonitoringSystem generalIndicatorsMonitoringModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Monitoring of general indicators has started!");
            }
        };

        MonitoringSystem errorMonitoringModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Bug tracking monitoring has started!");
            }
        };

        MonitoringSystem securityModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Security monitoring has started!");
            }
        };

        generalIndicatorsMonitoringModule.startMonitoring();
        errorMonitoringModule.startMonitoring();
        securityModule.startMonitoring();
    }
}
