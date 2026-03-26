# Monitoring

Monitoring tools to track metrics and critical situations.

💡 [Tap here](https://new.oprosso.net/p/4cb31ec3f47a4596bc758ea1861fb624) **to leave your feedback on the project**. It's anonymous and will help our team make your educational experience better. We recommend completing the survey immediately after the project.

## Contents

1. [Chapter I](#chapter-i) 
2. [Chapter II](#chapter-ii) \
   2.1. [Getting metrics and logs](#part-1-getting-metrics-and-logs) \
   2.2. [Visualization](#part-2-visualization) \
   2.3. [Critical event monitoring](#part-3-critical-event-monitoring) 

## Instructions

How to learn at “School 21”:

- Here, you’ll find a unique learning experience with a lot of freedom. You’re given a task and left to find your own way to solve it, using whatever resources work best for you — whether that’s the Internet or AI tools like GigaChat. Just be mindful of information quality: verify, think critically, analyze, and compare.
- Peer-to-peer (P2P) learning is the exchange of knowledge and experience with peers, where everyone acts as both mentor and student. This approach allows you to gain a deeper understanding of the material by learning from one another.
- Feel free to ask for help: around you are peers who are also navigating this path for the first time. Share your own experience and ideas with others.  Join Rocket.Chat to stay updated with the latest community announcements. 
- Your learning is meaningless if you just copy someone else’s solutions. When receiving help from others, always make sure you fully understand the “why”, “how”, and “purpose” behind the solution. Don’t be afraid to make mistakes. 
- Does the task seem impossible? Take a break, get some fresh air and clear your mind — this has helped many people. Maybe after that, the solution will come to you naturally.
- The learning process is just as important as the result. It’s not just about completing the task — it’s about understanding HOW to solve it. 

How to work with the project:

- Before starting, clone the project from GitLab into a repository with the same name.
- All files should be created inside the _src/_ folder of the cloned repository.
- After cloning the project, create a _develop_ branch and do all your development there. Then, push the _develop_ branch to GitLab.
- Your directory should not contain any files other than those specified in the assignments.

## Chapter I

Application monitoring is an important part of any software development. Monitoring usually involves collecting and visualizing metrics and logs of both the application and the infrastructure in which the application is deployed. 

**Metrics** are numeric values that show the actual parameters and performance of the application. **Logs** are text records with important information about the progress of the application.

The combination of Prometheus and Grafana is in fact one of the most frequently used solutions for collecting and visualizing metrics in applications and distributed systems. Loki is a tool inspired by Prometheus for collecting textual logs.

## Chapter II

The result of the work must be a report with detailed descriptions of the implementation of each of the points with screenshots. The report is prepared as a markdown file in the `src` directory named `REPORT.MD`.

## Part 1. Getting metrics and logs

In this chapter you will configure Prometheus and Loki to collect metrics and logs for the application.

### Task 

1. Use the Docker Swarm from the first project. 

2. Use the Micrometer library to write the following application metrics collectors: 
   - number of messages sent to rabbitmq;
   - number of messages processed in rabbitmq;
   - number of bookings;
   - number of requests received at the gateway;
   - number of user authorization requests received.

3. Add application logs using Loki.

4. Create a new stack for the Docker Swarm of services with Prometheus Server, Loki, node_exporter, blackbox_exporter, cAdvisor. Check receiving metrics on port 9090 via a browser.

## Part 2. Visualization

In this chapter you will configure Grafana to visualize metrics and logs.

### Task

1. Deploy Grafana as a new service in the monitoring stack.

2. Add a dashboard with the following metrics to Grafana:
   - number of nodes;
   - number of containers;
   - number of stacks;
   - CPU usage for services;
   - CPU usage for cores and nodes;
   - spent RAM;
   - available and used memory;
   - number of CPUs;
   - google.com availability;
   - number of messages sent to rabbitmq;
   - number of messages processed in rabbitmq;
   - number of bookings;
   - number of requests received at the gateway;
   - number of user authorization requests received;
   - application logs.

## Part 3. Critical event monitoring

In this chapter you will configure the Alert Manager to alert you about critical events.

### Task 

1. Deploy Alert Manager as a new service in the monitored stack.

2. Add the following critical events:
   - available memory is less than 100 MB;
   - used RAM is more than 1 GB;
   - CPU usage for the service exceeds 10%.

3. Configure notifications via personal email and Telegram.
