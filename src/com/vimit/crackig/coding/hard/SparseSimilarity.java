package com.vimit.crackig.coding.hard;

import java.util.*;
import java.util.Objects;
import java.util.stream.Collectors;


public class SparseSimilarity {
    public static void main(String[] args) {
        List<Document> documents = new ArrayList<>();
        Integer words1[] = {1, 2, 3, 4, 5};
        Integer words2[] = {-6, 2, 3, 4, 5};
        Document doc1 = new Document(1,  Arrays.asList(words1));
        Document doc2 = new Document(2,  Arrays.asList(words2));
        documents.add(doc1);
        documents.add(doc2);
        computeSimilarities(documents).entrySet().stream().forEach((e) -> System.out.println("" + e.getKey() + e.getValue()));

    }

    public static Map<DocPair, Double> computeSimilarities(List<Document> documents){
        Map<DocPair, Double> documentSimilarities = new HashMap<>();
        for(int i =0; i<documents.size(); i++){
            Document firstDocument = documents.get(i);
            for(int j = i+1; j<documents.size(); j++){
                Document secondDocument = documents.get(j);
                double similarity = calculateSimilaity(firstDocument, secondDocument);
                documentSimilarities.put(new DocPair(firstDocument.getDocId() , secondDocument.getDocId()), similarity);
            }
        }
       return documentSimilarities;

    }

    public static double calculateSimilaity(Document firstDocument, Document secondDocument){
        Set<Integer> firstDocumentWords = firstDocument.getWords().stream().collect(Collectors.toSet());
        long intersection = secondDocument.getWords().stream().filter(i -> firstDocumentWords.contains(i)).count();
        double union = firstDocument.size()+ secondDocument.size() - intersection;
        return intersection/union;

    }

}

class DocPair {
    int firstDocId;
    int secondDocId;

    public DocPair(int firstDocId, int secondDocId) {
        this.firstDocId = firstDocId;
        this.secondDocId = secondDocId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocPair docPair = (DocPair) o;
        return firstDocId == docPair.firstDocId &&
                secondDocId == docPair.secondDocId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstDocId, secondDocId);
    }

    @Override
    public String toString() {
        return "DocPair{" +
                "firstDocId=" + firstDocId +
                ", secondDocId=" + secondDocId +
                '}';
    }
}

class Document{
    private int docId;
    private List<Integer> words;

    public Document(int docId, List<Integer> words) {
        this.docId = docId;
        this.words = words;
    }

    public int getDocId() {
        return docId;
    }

    public List<Integer> getWords() {
        return words;
    }

    public int size(){
        return words.size();
    }
}
