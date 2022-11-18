package org.example.config;

public interface Repairable {

	public void startRepair();

	public void finishRepair();

	public boolean isRepairing();
}
