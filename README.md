# LR4
This is LR4. FileManagerMaven

This FileManager can work with text and xlsx files. You can create, delete, find and rename files with format ".txt" and also find
key words in the text of the file. Also you can read the Microsoft Excel sheets and edit them.

Choosing directory

After you choosing any action before you start perform operations on files the program will ask you to enter a path to
directory. Depending on operating system it will give you an example of the correct path entry. For example,
is you are a windows user after you choosing action you will see the following message: "Enter path. Example: "C:\Users\Desktop\"").

Keys to action

To use the program enter the following keys:

Create File - enter '1'. After successfully creating a file you will see next message - "File named "fileName" created
successfully!". File names must not be repeated. If you want to create a file with a name that already exists you will
see next message: "File with name "fileName" already exists!".

Delete File - enter '2'. You must enter the name of an existing file is to delete it. After successful removal you will
see the following message: "File "fileName" deleted successfully!". If a file with that name does not exist the message
will be: "Delete operation failed. No such file with name "fileName"."

Rename File - enter '3'. First of all the program will ask you to enter old name of an existing file. THan to rename
existing file you must enter new name. After successful renaming you will see the following message: "File renamed successful!".
If file with name the you entered already exists renaming operation will be failed and you will see the following message:
"File rename operation failed! File with name "filename" already exists."

Find Word in file - enter - '4'. You can also find a word in file. After entering file name and word that you need to find
you will see message "File contains provided word on the "__" line.".

Replace Word in file - enter '5'. To replace the word in a file first of all you must enter a file name to found it. Than you
can enter existing word and new word that will replace it.

Read xlsx files - enter '6'. Displays all the content of the Microsoft Excel file with the 'xlsx' extension.

Insert new data into xlsx file - '7'. New data will appers in the first cell in Microsoft Excel file.

Exit - enter '0'. To finish program and exit.