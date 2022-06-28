public class Main {
    public static void main(String[] args) {
        MonitoringSystem generalIndicatorsMonitoringModule = getGeneralIndicatorsMonitoringModule();
        MonitoringSystem errorMonitoringModule = getErrorMonitoringModule();
        MonitoringSystem securityModule = getSecurityModule();

        generalIndicatorsMonitoringModule.startMonitoring();
        errorMonitoringModule.startMonitoring();
        securityModule.startMonitoring();
    }

    private static MonitoringSystem getGeneralIndicatorsMonitoringModule() {
        MonitoringSystem generalIndicatorsMonitoringModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Monitoring of general indicators has started!");
            }
        };

        return generalIndicatorsMonitoringModule;
    }

    private static MonitoringSystem getErrorMonitoringModule() {
        MonitoringSystem errorMonitoringModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Bug tracking monitoring has started!");
            }
        };

        return errorMonitoringModule;
    }

    private static MonitoringSystem getSecurityModule() {
        MonitoringSystem securityModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Security monitoring has started!");
            }
        };

        return securityModule;
    }
}
