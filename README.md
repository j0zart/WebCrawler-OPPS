**WebCrawler-OPPS**
**Group 4**

Tuan Tran, 
Deny Kulasinac, 
Zian Chowdhury, 
Johnathan Hoang

**One Page Note:**

**Input:**
The Java web crawler program's primary input is a URL specified at the start of the main method. This URL represents the starting point of the web crawling process. Additionally, the program operates with a pre-defined depth limit, set to 5 levels in this case. This limit controls how deep the crawler goes into linked pages from the initial URL. There are no direct user inputs while the program is running, as the crawling process is automated based on the initial URL and the depth limit.

**Output:**
The output of the web crawler consists of console prints providing information about each successfully visited webpage. For each webpage that the crawler accesses without encountering errors, the program outputs two pieces of information: the URL of the visited page and the title of that page as extracted from its HTML content. This output is displayed in the console or command line interface from which the program is run, offering a log of the crawler's journey through the web from the starting URL up to the specified depth.

**How to Run code: (To run our code we will be using Github and IntelliJ IDE.)**

Copy code using URL from github to clone repository.
Launch IntelliJ IDEA and select “Get from VCS”
Copy the copied URL into the “URL:” box and select preferred Directory.
Click on Clone.
Once the project is open in IDE, locate “build.gradle” and Sync.
Find WebCrawler.java which is located in src\main\java\org.example\WebCrawler
In Line 16 replace text in quotation marks “” with your URL.
Run Code.
