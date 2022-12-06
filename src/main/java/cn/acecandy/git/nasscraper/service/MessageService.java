package cn.acecandy.git.nasscraper.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.acecandy.git.nasscraper.dao.data.Message;

@Service
public interface MessageService {

    public List<Message> getAll();

    public Message get(Long id);

    public Message create(Message message);

    public String loadFile(String filePath) throws FileNotFoundException, IOException;

    public String saveIntoFile(String filePath) throws IOException;
}