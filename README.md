# codingQuiz9

mini-max sum:
* time complexity: O(nlog(n)) because the sorting function has the slowest time complexity in the function, and that takes O(nlog(n) time. 
* space complexity: O(1) because it stores 2 constant variables

weighted uniform strings:
* time complexity: O(mn) where m is the length of the string s and n is the number of queries. This is because the for loop that goes through the queries, in each iteration checks whether the list of the possible weights of substring of s contains each query. Checking this is a linear operation inside of the linear for loop. 
