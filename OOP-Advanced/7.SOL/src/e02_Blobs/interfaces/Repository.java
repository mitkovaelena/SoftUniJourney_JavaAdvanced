package e02_Blobs.interfaces;

import java.util.Collection;

public interface Repository {

    void add(Blob blob);

    Blob getBlobByName(String name);

    Collection<Blob> getAllBlobs();

    void updateStats();
}
