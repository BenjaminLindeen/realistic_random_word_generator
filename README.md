# realistic_random_word_generator 📖

Generate pronounceable English gibberish with ease! Gibberisher, rooted in linguistic patterns and advanced data structures, crafts gibberish that sounds like real English. Useful for generating nonsense words for pedagogical purposes or just for fun.

## 🎯 Project Overview

Creating random words that seem pronounceable in English can be surprisingly challenging. A simple random combination of letters can result in an output like "zqzzrz". Gibberisher is designed to understand the subtle intricacies of English letter combinations to produce words like "demors" instead.

## 🔍 Theory Behind Gibberisher

There are algorithms that randomly generate words, but they don't necessarily produce pronounceable results. Gibberisher is based on a more refined model, considering:

1. **Frequencies of Individual Letters**: For instance, "e" appears more frequently than "z" in English.
2. **Letter Sequencing**: Some letters or sequences are more likely to follow others, e.g., "ont" can be followed by 'r' or 'e'.
3. **Word Start & End Dynamics**: Utilizes partial word segments to determine word beginnings and employs a "STOP" letter mechanism to determine appropriate word endings.

## 🚀 Usage

Here's a pseudo-code to give you an idea of how Gibberisher works:

```plaintext
word = ""
While word doesn’t end with the STOP letter:
    sample = get the last k letters of word
    get the letter counts for sample
    generate nextLetter based on those counts
    word = word + nextLetter
return word.
```

## 🛠 Key Features
1. Diverse Word Generation: Suitable for different languages with slight tweaks.
2. Efficiency: Optimized data structures to handle a dictionary of 62,915 English words.
3. Customizability: Adjust the word length and other parameters to fit your needs.

## 🙌 Contributions
Feel free to fork, make pull requests or open issues. We appreciate any contributions.
