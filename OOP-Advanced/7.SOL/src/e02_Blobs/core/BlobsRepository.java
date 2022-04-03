package e02_Blobs.core;

import e02_Blobs.interfaces.Blob;
import e02_Blobs.interfaces.Repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlobsRepository implements Repository{
    private Map<String, Blob> blobs;

    public BlobsRepository() {
        this.blobs = new LinkedHashMap<>();
    }

    @Override
    public void add(Blob blob){
        this.blobs.put(blob.getName(), blob);
    }

    @Override
    public Blob getBlobByName(String name){
        return blobs.get(name);
    }

    @Override
    public Collection<Blob> getAllBlobs(){
        return this.blobs.values();
    }

    @Override
    public void updateStats(){
        for(Blob blob : this.blobs.values()){
            blob.updateStats();
        }
    }
}
