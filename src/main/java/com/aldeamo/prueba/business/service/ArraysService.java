package com.aldeamo.prueba.business.service;

import com.aldeamo.prueba.model.dto.RequestDTO;
import com.aldeamo.prueba.model.repository.ArraysRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ArraysService {

    final ArraysRepository arraysRepository;

    public ArraysService(ArraysRepository arraysRepository) {
        this.arraysRepository = arraysRepository;
    }

    public Optional<String> findArrayById(int id) {
        return arraysRepository.findArrayById(id);
    }

    public String calculateArray(RequestDTO peticion) {

        final int[] primeArray = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71};
        int iteration = peticion.getIteration();
        if (iteration > primeArray.length) {
            return "La cantidad de iteraciones maxima permitida es: " + primeArray.length;
        }
        List<Integer> arrayB = new ArrayList<>();
        List<Integer> arrayA = new ArrayList<>();
        List<Integer> resultData = new ArrayList<>();
        Optional<String> dataValue = findArrayById(peticion.getIndex());
        if (dataValue.isEmpty()) {
            return "El indice seleccionado no contiene ningun dato.";
        }
        int[] data = convertStringToIntArray(dataValue.get());
        for (int i = 0; i < iteration; i++) {
            for (int j = data.length - 1; j >= 0; j--) {
                validate(data[j], primeArray[i], arrayA, arrayB);
            }
            data = arrayA.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
            resultData.addAll(arrayB);
            arrayB.clear();
            if (i < iteration - 1) {
                arrayA.clear();
            }
        }
        if (!arrayA.isEmpty()) {
            resultData.addAll(arrayA);
        }

        return resultData.toString();
    }

    private int[] convertStringToIntArray(String array) {
        Stream<String> numbers = Arrays.stream(array.split(","));
        return numbers.mapToInt(Integer::parseInt).toArray();
    }

    private void validate(int numberEval, int primeEval, List<Integer> arrayA, List<Integer> arrayB) {
        double result = numberEval % primeEval;
        if (result > 0) {
            arrayA.add(numberEval);
            return;
        }
        arrayB.add(numberEval);
    }
}
