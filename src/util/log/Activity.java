package util.log;

import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Activity {
    private List<String> activities = new ArrayList<String>();
    private File arquivo = new File("atividades.log");
  
    public Activity(String atividade) {
                
      if( !this.arquivo.exists()){
          try { this.arquivo.createNewFile(); } catch(IOException e) {}
      }
  
      this.activities.add(atividade + " " + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
      
      try { Files.write(Paths.get(this.arquivo.getPath()), this.activities, StandardOpenOption.APPEND); } catch(IOException e) {}
  
    }
}
