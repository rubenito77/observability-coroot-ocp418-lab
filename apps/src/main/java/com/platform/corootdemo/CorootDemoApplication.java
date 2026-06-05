package com.platform.corootdemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;
@SpringBootApplication
@RestController
public class CorootDemoApplication {
  private final Random random = new Random();
  public static void main(String[] args){ SpringApplication.run(CorootDemoApplication.class,args); }
  @GetMapping("/") public String home(){ return "Java Spring Boot Coroot Demo - OK - " + LocalDateTime.now(); }
  @GetMapping("/fast") public String fast(){ return "fast response"; }
  @GetMapping("/slow") public String slow() throws Exception { Thread.sleep(2000); return "slow response"; }
  @GetMapping("/random") public String randomLatency() throws Exception { int d=random.nextInt(3000); Thread.sleep(d); return "random latency: "+d; }
  @GetMapping("/error") public String error(){ throw new RuntimeException("simulated error"); }
  @GetMapping("/cpu") public String cpu(){ long end=System.currentTimeMillis()+3000; long c=0; while(System.currentTimeMillis()<end){ c++; Math.sqrt(c);} return "cpu load "+c; }
  @GetMapping("/memory") public String memory(){ List<byte[]> m=new ArrayList<>(); for(int i=0;i<50;i++) m.add(new byte[1024*1024]); return "allocated 50MB"; }
  @GetMapping("/health") public String health(){ return "healthy"; }
}