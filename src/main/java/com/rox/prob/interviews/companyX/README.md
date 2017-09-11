#Authorisation Application

### Problem
The customer’s system produces simple JSON files that describe a request for some resource (resource request). The customer needs a console application that can read these files, and produce a __PERMIT__ or __DENY__ response for each one, based on some authorisation rules specified in a configuration file.
You should construct a console application that accepts a filename pointing to a resource request, and prints a __PERMIT__ or __DENY__ decision to the console, by applying the rules from the configuration file to the resource request.
 
### Specification
The console application should take two arguments: the filename for the configuration file, and the filename for a resource request file.
A resource request is a JSON-formatted file, and contains one or more key-value pairs. The keys are always strings, and the values are either strings or integers. An example resource request is given below:

```json
{
  "name" : "John Smith",
  "email" : "john.smith@example.com",
  "debit" : 100,
  "balance" : -1
}
```

The application should apply the authorisation rules to this resource request. Every rule operates on the map of key-value pairs, and produces either a __PERMIT__ or __DENY__ decision. The application then aggregates these decisions and produces an overall decision of __PERMIT__ or __DENY__, which it then prints to the console’s standard output stream. If the overall decision is __PERMIT__, then the application should exit with a status code 0. If the overall decision is __DENY__, then the application should exit with a status code 1.

### Authorisation Rules
There are four different kinds of rule that can be applied to a resource request:

 - __MATCH__ (_key_, _regexp_) - If the key exists, and the value for that key matches the regexp, produce __PERMIT__, otherwise produce __DENY__.
 - __GREATER_THAN__ (_key_, _number_) - If the key exists, and the value for that key is greater than the number, produce __PERMIT__, otherwise produce __DENY__.
 - __LESS_THAN__ (_key_, _number_) - If the key exists, and the value for that key is less than the number, produce __PERMIT__, otherwise produce __DENY__.
 - __EXISTS__ (_key_) - If the key exists, produce __PERMIT__, otherwise produce __DENY__.
 
The application may be configured to apply more than one rule to the request contexts. Therefore, we need a decision aggregator function to produce a single authorisation decision. The application should implement the following decision aggregator functions:

 - __DENY_OVERRIDES_PERMIT__ (_decisions[]_) - If any of the decisions is __DENY__, produce __DENY__, otherwise produce __PERMIT__.
 - __PERMIT_OVERRIDES_DENY__ (_decisions[]_) - If any of the decisions is __PERMIT__, produce __PERMIT__, otherwise produce __DENY__.
 - __MAJORITY_WINS_BIAS_PERMIT__ (_decisions[]_) - If the number of __DENY__ decisions is greater than the number of __PERMIT__ decisions, produce __DENY__, otherwise produce __PERMIT__.
 - __MAJORITY_WINS_BIAS_DENY__ (_decisions[]_) - If the number of __PERMIT__ decisions is greater than the number of __DENY__ decisions, produce __PERMIT__, otherwise produce __DENY__.
 
### Configuration

You will need to create a configuration file that contains:

 - A list of authorisation rules to apply to the resource requests
 - The decision aggregator function to use

