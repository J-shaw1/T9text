T9text
======
This was the final project for the software workshop module in first year. The was was to create a simple predictive text application to predict words when the user is typing using T9 Text. The reason there is so few commits is that we had to use SVN for source control, but I have since moved all the code to Git

There was a major focus on looking at different data structures used to contain all the words in the dictionary we were given (approx. 500,000 words).

The first implentation <a href="https://github.com/J-shaw1/T9text/blob/master/src/predictive/DictionaryListImpl.java"> (DictionaryListImpl.java)</a> was a simple list of all the words, this method was very inefficient and took a long time to retrive words from the dictionary when the user was pressing keys on the GUI

The second implementation <a href="https://github.com/J-shaw1/T9text/blob/master/src/predictive/DictionaryMapImpl.java">(DictionaryMapImpl.java)</a> used a hash map to hold the words, mapping from a word signature (for example '43556' for the word 'hello') to a list of words that match this signature. This implementation was more efficient than the first, however it took up alot of memory and could not predict words, but could only show a word once you had entered the full type signature

The final method <a href="https://github.com/J-shaw1/T9text/blob/master/src/predictive/DictionaryTreeImpl.java">(DictionaryTreeImpl.java)</a> to store the dictionary was by using a tree. Each node of the tree contains a HashSet of words, the depth of the node, and an array of its children. This implementation was very fast to build and very quick to retrive full and partial words from (~log<sub>2</sub>N complexity)

The GUI was built so that it could use any implementation of dictionary, this was made possilbe by simply implementing a common Dictionary <a href="https://github.com/J-shaw1/T9text/blob/master/src/predictive/Dictionary.java">(Dictionary.java)</a> interface.
