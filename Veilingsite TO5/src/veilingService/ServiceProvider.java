package veilingService;

import veilingQuerys.IVeilingService;


public class ServiceProvider {
	private static IVeilingService veilingService = new VeilingService();

	public static IVeilingService getveilingService() {
		return veilingService;
	}
	
}
