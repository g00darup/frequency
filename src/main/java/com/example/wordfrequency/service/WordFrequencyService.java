package com.example.wordfrequency.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WordFrequencyService {

    public Map<String, Long> wordMap (String text){
        HashMap<String,Integer> result = new HashMap<>();
        List<String> arr = List.of(text.split(" "));


        Map<String,Long> map =  arr.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
//        arr.forEach(str -> {
//            if (result.containsKey(str)) {
//                result.put(str, result.get(str) + 1);
//            } else {
//                result.put(str, 1);
//            }
//        });
        return map;
    }
}
