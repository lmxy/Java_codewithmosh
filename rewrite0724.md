# 3.7.5 Join thread
Now, sacnning a file is a time consuming task, it's not going to happen immediately like incremental an integer, it may take a few seconds. So we should run it in a seperate thread, but we should do that only after we have downloaded the file. Here is the thing. How can we know if the download thread has finished, downloading a file may take a second, a miniute or longer, we cannot predict it. So here we cannot use thread sleep to make to make the current thread sleep for 5 seconds, because the download may take longer. To solve this problem, we should join threads. So after we start the download thread we call thread dot join and this will make the current thread that is the main thread that is executing code, wait for the completion of the download thread. So this call is going to bloch the current thread until the download thread has finished. Once the method returns, then we can print message like these. Now, just like this leap method, the join method throws an interruptedException. So we should handle it here. Let's rapid with a try cache block. All right. So we start a download thread, then we join the current thread with that tread. So this will make the current thread wait for the completion of that thread, and then we'll print this message. Let's run the program. So with the join method, we tell the current thread to wait for the completion of another thread. And that means why the thread is waiting, it cannot do other things. For example, in the case of a desktop or a mobile app, this main thread is responsible for handling UI event. Like mouse clicks and keystrokes. So if you make the main thread wait for another thread, it cannot respond to this UI advance while it's waiting. So the UI will freeze, and the user will not be able to resize or move the application window. But don't worry, later I will show you a better way to have one task start after another task finishes without causing the current thread to wait. For now, I just want you to understand what joining is and how it works.
# 3.7.6 interrupting a thread
Quite often when dealing with long live tasks, we want to give our users the ability to cancel. So here we are starting a download task, what to do if we want cancel after a second? First go back to our DownloadFileTask. Instead of passing this thread to simulate a long running task, let's add a for loop that continuously print a message on terminal. So for i equals 0, as long as it's less than Integer.MAX_VALUE, I want a really large number. So we can see this task going for a little while. i++, and here we print downloading byte i. With this we can easily verify if our download actually gets cancelled. Now, back to our demo class. I want to cancel this thread after one second. So let's pause the current thread for one second. Just like before, we should handle the interrupted exception here. So restarting a separate thread to download a file, and then have the current thread which is the main thread that is excuting this code, wait for one second. Now, to cancel the download thread, here we call thread dot interrupt. Let's run a program. So our download is going, and going, and going. It cannot help stopping. Let me stop the program first. Alright, the reason our download thread didn't stop is that calling the interrupt method doesn't actually force the thread to stop. It simply sent an interrupt request to the thread. It's up to that thread to decide if we should stop what it's doing. So back to our DownloadFileTask class. Here we should continuously check for an interrupt request. If we get that request that will have to stop the download. So in this for loop, let's add a code block. First we check for an interrupt request. So we typed if thread dot current thread, we can access to the current thread, then call isInterrupted. If this returns true, then we can break out of this loop or simply return. Otherwise, we're going to download byte. Now let's run our programming again. So after one second, our download stoped. So remember, the interrupt method doesn't force the thread to stop what it's doing. It simply sends an interrupt request to support interruption we should constantly check for the interrupted requests and act accordingly. Now, if a thread is sleeping, and we send an interrupt request to it, it throws an exception. That is why you have to handle this InterruptedException when pausing a thread.
# 3.7.7 Concurrency Issues
In all the examples I've shown you so far, our download threads have been isolated from each other. But in a real world scenario, sometimes our threads may need to access and modify shared resources. 
Now, multiple threads access the same object, and at least one of them change this object, we're going to run into a couple of issues. The first issue happens when multiple threads try to modify the same data at the same time. It's like having one burger and 3 people wanting to eat it at the same time. It's not going to work. So if multiple threads try to change the same data, we may get the wrong results or our application may crash. When this happens, we say we have a race condition, which means multiple threads are racing or cometing to modify some data. I'll show you an example. This in the next video. Another issue happens when one thread changes the shared data. But its changes are not visible to other threads. So different thread will have different views of the shared data. This is what we call a visibility problem. So, if multiple threads access the same data, and at least one of them tries to change it, we'll gonna have some problems. If they only want to read the shared data, that's perfectly fine. By the way, this problem is not specific to Java. These are properties of consurrent systems, we have to see problem in databases, because multiple users can modify the same data at the same time. I talked about this in my ultimate sequel course. So if you want to build a multiple thread application, you need to have a proper understanding of this problems and know how to prevent them. You should write cold that can be safely executed by many threads in parallel. This is what we called Thread-safe Code. It's one of those terms that you see in the Java documentation a lot. Some classes are thread sage, which means they can be safely used across many parallel threads. We'll talk about this later. So, the next video I'm going to show you concurrency problems in an action.
# 3.7.8 Race Conditions
Let's see, as part of multiple files, we want to show the total number of bytes we have downloaded so far. So we need to store the total value somewhere and have multiple threads incremented as they are downloading files, this is going to cause a race condition, which means multiple threads are racing or competing to modify a shared resource. Let me show you. So I'm going to add a new class in this project. We call it download status. Here we need a field for storing the total number of bytes we have downloaded. Now, let's create a getter for this field. So we put the carrot one the field name, press Alt Enter, and create a getter. We also need a method for incrementing this field. So, instead of adding a setter, I would prefer to add an increment method. So each thread can call this to increment our field. It prevents us from accidentally resetting the total bytes in a thread. So, public void incrementTotalBytes. And here, we type totalBytes++. &** all of downloaded phrase to report to a single download status object. So in our demo class, let's create download status object, new download status. Now we start 10 download threads.
Now, we should pass this status object to each DownloadFileTask. So, let's pass it here. Now we let Intellij create a constructor for receiving this value. Now, we should create a field to store this status object. So, we press Alt Enter here one more time, and create field for parameter "status". There you go. So here is the filed and resetting it in the constructor. Now, let's change the run method a little bit. Instead Of Integer.MAX_VALUE, let's use 10_000. So, we want to simulate a scenario where each file is 10_000 bytes. We can also add an underline here. This makes our code cleaner and more readable. So in each iteration
Now, we don't need this message anymore. SO simpfy our code. Back to demo class. We're starting 10 download threads, and sharing a single status object accross these threads. Now, once all these threads are completed, we should print the total number of bytes we have downloaded. So we have to wait for all these threads to finish. Now, we cannot call thread.join(), because this will make the main thread late for each download to finish before starting another download. Because this join method is a blocking method. So in the first iteration, we create a thread we start it, and then we wait for that thread to finish before going to the second iteration to create a second thread. So, we cannot use the join method here, we should start all the threads simultaneously and join with all of them.
So let's declare a list of threads. A list of thread we call the threads and set it to a new ArrayList. Now, everytime we start a thread, we added to our list. So `threads.add(thread)`. 
Now here we need another for loop to iterate over all the threads and join with them. So ` for `. So, with this for loop, we can wait for all this download thread to finish, then we can print the total number of bytes we have downloaded.
So here we have 10 download task and each task is going to download 10_000 bytes. So when I run this program, we expect to see 100,000 bytes, but that's not gonna happen. Let me show you. This is a race condition in action, because multiple threads are racing or competing to update the total number of bytes. Now let me explain what happens under the hood.
This operation involves three steps. So even though we have only one line of code, there will be 3 steps happening under the hood. First, the value of this field has to be read from the main memory and stored into CPU. Next, the CPU is going to increment this value, and then the updated value is going to stored in the memory. So we have 3 steps. And we call this a non atomic operation, because it involves multiple steps. In contrast, an atomic operation is like an atom, we cannot break it down into many steps. Now, imagine 2 threads trying to call this method at the same time, let's say the value of this field is 0. All these thread will read this value concurrently. They both incremented and write to the memory. So the result is 1 instead of 2. This is how we lose an update. And the next video will be looking at various stragie to prevent this problems.
# Strategies for Thread Safety
We have a few strategies for writing thread safe code, this code can be safely executed across multiple threads. The simplest solution is not to share data across threads in the first place. This is called confinement, because we want to confine or restrict each thread to have its own data. For example, instead of sharing a download status object across many download tasks, you could have each download task have its own download status object. When all these tasks are completed, wa can combine the result. So this is the simplest strategy. I will show you how to do this in the next video. Another strategy is using immutable or unchangeable objects. An object is immutable, the data cannot be changed after it is created. For example, the string class in Java is immutable. If it convert a string to uppercase, we get a new string object. The original string object is not changed. So sharing an immutable objects between threads is totally fine. Because these threads can only read immutable objects, they cannot modify them. Another strategy is to prevent multiple threads from accessing the same object and concurrency. this is called synchronization because we synchronization or coordinate the access to an object across different threads. We do that by using locks. So we put a lock on certain parts of our code, and only we thread at a time can excute that part, other threads have to wait. So synchronization forces the code to run sequentially which is against the idea of concurrency. Plus, implementing synchronization is challengign and error-prone. One of the problems we run into is a deadlock, which happens when 2 threads wait for each other indefinitely. So thread 1 waits thread 2, and at the same time, thread 2 waits for thread 1.