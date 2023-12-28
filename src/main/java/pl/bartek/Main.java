package pl.bartek;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> urls = new ArrayList<>(List.of(
                "/username/bartek123/info/age",
                "/username/jan100/info/location",
                "/username/anna6251/info/height"
        ));

        List<List<String>> parts = urls.stream()
                        .map(url -> List.of(url.split("/")).stream()
                                .filter(url1 -> !url1.isBlank())
                                .toList())
                .toList();

        List<String> url1Parts = parts.get(0);
        int size = url1Parts.size();
        List<Boolean> isVariableList = new ArrayList<>();

        for(int i = 0; i < size; i++){
            boolean isVariable = false;
            for(int j = 1; j < parts.size(); j++){
                if(!Objects.equals(parts.get(j).get(i), url1Parts.get(i))){
                    isVariable = true;
                    break;
                }
            }
            isVariableList.add(isVariable);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append("/").append(isVariableList.get(i) ? "**variable**" : url1Parts.get(i));
        }

        System.out.println(sb);

    }
}