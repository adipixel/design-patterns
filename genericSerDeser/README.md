# Generic Serializer and De-serializer

- **Strategy design pattern** is used to implement this system.
- **Serializer:** Creates objects of corresponding classes given in the input file, overriddes hashCode
and equals methods, and compares and stores the objects into a ArrayList data structure
- **De-serializer:** Retrives objects stored in the data structure, and prints into a text file in special XML like format 
