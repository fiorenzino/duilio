package org.giavacms.api;

public interface DuilioService {

	public DuilioInfoService getDuilioInfoService();

	public void setDuilioInfoService(DuilioInfoService duilioInfoService);

	public boolean execute(DuilioInfoService duilioInfoService);

	public boolean execute();
}
