1. ���� �⺻ �� git uri �Է� �� ���� �� ���� �߻� : https://localhost:9900/configtest/dev->>>>http://localhost:9900/configtest/dev �� �ذ�
--request send ��, https �������� �����ϳ� server�� ���������� http�� �����Ǿ� �־���.
send �� http�� �����ϰų�, server�� �������� https �� �������ָ� ������ �ذ�

2022-02-03 21:11:02.549  INFO 23940 --- [nio-9900-exec-1] o.apache.coyote.http11.Http11Processor   : Error parsing HTTP request header
 Note: further occurrences of HTTP request parsing errors will be logged at DEBUG level.

java.lang.IllegalArgumentException: Invalid character found in method name [0x160x030x010x000xf70x010x000x000xf30x030x030x120xf60x930x1b0xf20x970x87Z0xb7P0x050x8d0x81j0xf9e0x85"0xed0x8dZI|~0xf60xa0w0xff0x090xcem0xed ]. HTTP method names must be tokens
	at org.apache.coyote.http11.Http11InputBuffer.parseRequestLine(Http11InputBuffer.java:419) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:269) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) [tomcat-embed-core-9.0.56.jar:9.0.56]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:895) [tomcat-embed-core-9.0.56.jar:9.0.56]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1732) [tomcat-embed-core-9.0.56.jar:9.0.56]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-9.0.56.jar:9.0.56]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) [tomcat-embed-core-9.0.56.jar:9.0.56]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) [tomcat-embed-core-9.0.56.jar:9.0.56]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-9.0.56.jar:9.0.56]
	at java.lang.Thread.run(Thread.java:750) [na:1.8.0_321]
