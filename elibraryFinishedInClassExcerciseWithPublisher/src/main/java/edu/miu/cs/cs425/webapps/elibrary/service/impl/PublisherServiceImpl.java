package edu.miu.cs.cs425.webapps.elibrary.service.impl;

import edu.miu.cs.cs425.webapps.elibrary.model.Publisher;
import edu.miu.cs.cs425.webapps.elibrary.repository.PublisherRepository;
import edu.miu.cs.cs425.webapps.elibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
 private PublisherRepository publisherRepository;
    @Override
    public List<Publisher> getPublisher() {
        return publisherRepository.findAll(Sort.by("name"));
    }

    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
}
