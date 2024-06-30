package evaluations.model;

import java.util.HashMap;
import java.util.Map;

public class Evaluations {

 private Map<String,Evaluation> results= new HashMap<>();

 public void add(String name, Evaluation evaluation){
   results.put(name, evaluation);
 }

 public Map<String, Evaluation> getResults() {
  return results;
 }
}
