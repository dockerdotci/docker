import hudson.model.*;
import jenkins.model.*;


Thread.start {
      sleep 10000
      println "--> setting agent port for jnlp"
      def env = System.getenv()
      def instance = Jenkins.getInstance()
      int port = env['JENKINS_SLAVE_AGENT_PORT'].toInteger()
      instance.setSlaveAgentPort(port)
      println "--> setting agent port for jnlp... done"

      // avoid overloading jenkins master
      println "--> setting jenkins master to 0 executors"
      instance.setNumExecutors(0)
      println "--> setting jenkins master to 0 executors... done"

      instance.save()
}
