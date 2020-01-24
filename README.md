# pmml-demo2
Java demo of a PMML model originally trained with Python sklearn.neural_network.MLPRegressor

## Prerequisites
 - Java 8
 - Maven 3

## To run it

```
mvn clean package install
cd target
java -jar project-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Expected output

```
Starting PMML demo...
predictor_1 0.3
predictor_2 0.2
predictor_3 3.2
predictor_4 1.2
Input fields: [InputField{name=predictor_4, fieldName=predictor_4, displayName=null, dataType=double, opType=continuous}, InputField{name=predictor_1, fieldName=predictor_1, displayName=null, dataType=double, opType=continuous}, InputField{name=predictor_2, fieldName=predictor_2, displayName=null, dataType=double, opType=continuous}, InputField{name=predictor_3, fieldName=predictor_3, displayName=null, dataType=double, opType=continuous}]
InputField{name=predictor_4, fieldName=predictor_4, displayName=null, dataType=double, opType=continuous}
InputField{name=predictor_1, fieldName=predictor_1, displayName=null, dataType=double, opType=continuous}
InputField{name=predictor_2, fieldName=predictor_2, displayName=null, dataType=double, opType=continuous}
InputField{name=predictor_3, fieldName=predictor_3, displayName=null, dataType=double, opType=continuous}
predictor_1=ContinuousDouble{opType=continuous, dataType=double, value=0.3}
predictor_2=ContinuousDouble{opType=continuous, dataType=double, value=0.2}
predictor_3=ContinuousDouble{opType=continuous, dataType=double, value=3.2}
predictor_4=ContinuousDouble{opType=continuous, dataType=double, value=1.2}
Predicted ---> price: 1.5697715124953397

```
