import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.*;
import org.jpmml.evaluator.visitors.DefaultVisitorBattery;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyApp {

    public static void main(String[] args) throws JAXBException, SAXException {

        System.out.println("Starting PMML demo...");

        final Map<String, Double> predictors = new HashMap<>();
        predictors.put("predictor_1", 0.3d);
        predictors.put("predictor_2", 0.2d);
        predictors.put("predictor_3", 3.2d);
        predictors.put("predictor_4", 1.2d);

        final Evaluator evaluator = new LoadingModelEvaluatorBuilder()
                .setLocatable(true)
                .setVisitors(new DefaultVisitorBattery())
                .load(MyApp.class.getResourceAsStream("model.pmml"))
                .build();

        predictors.forEach((key, value) -> System.out.println(key + " " + value));

        final List<? extends InputField> inputFields = evaluator.getInputFields();
        System.out.println("Input fields: " + inputFields);

        final Map<FieldName, FieldValue> inputMap = inputFields
                .stream()
                .peek(System.out::println)
                .collect(Collectors.toMap(
                        ModelField::getFieldName,
                        $ -> $.prepare(predictors.get($.getName().toString()))));

        inputMap.entrySet().forEach(System.out::println);

        final Map<FieldName, ?> results = evaluator.evaluate(inputMap);

        results.forEach((key, value) -> System.out.println("Predicted ---> " + key + ": " + value));
    }
}
