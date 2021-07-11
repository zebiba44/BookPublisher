package edu.miu.cs.cs425.webapps.elibrary.service;

import edu.miu.cs.cs425.webapps.elibrary.model.Publisher;

import java.util.List;

public interface PublisherService {
    public abstract List<Publisher> getPublisher();
    public abstract Publisher savePublisher(Publisher publisher);

}
