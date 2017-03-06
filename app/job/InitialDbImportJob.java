package job;

import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * Created by formation on 06/03/17.
 */
@OnApplicationStart
public class InitialDbImportJob extends Job {
    @Override
    public void doJob() throws Exception {
        Fixtures.deleteDatabase();
        Fixtures.loadModels("initial-data.yml");
    }
}
