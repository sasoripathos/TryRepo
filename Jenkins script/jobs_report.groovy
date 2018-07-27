/**
 * This module is a script to generate report for all (top level) jobs on Jenkins.
 * In this template, the report contains job name, URL, User ID and Name of the user who changed
 * the job configuration most recently, and last build status.
 *
 * This script should be executed in Script Console of Jenkins Master server, the output is
 * formatted for *.csv file.
 */

import hudson.plugins.jobConfigHistory.*;
import java.util.concurrent.*;

/*Constants which are used to measure last build status*/
def DAYS = 100;
// Change the DAYS into second, so that it is comparable with Jenkins time record
def INTERVAL = DAYS*24*60*60; 

/*print table hander*/
println "Jobs,URL,User ID,User Name,Last Build Status";

/*get all top level jobs, which are showed on Jenkins dashboard.*/
def topLevels = Jenkins.instance.getItems(TopLevelItem);

for (def it in topLevels) {
  def name = it.getName();
  def url = "Jenkins Home:" + it.getUrl();
  
  /*Print name and URL*/
  print name + "," + url + ",";
  def proj = new JobConfigHistoryProjectAction(it);
  def config = proj.getJobConfigs();
  
  /*Try to find the user who is the latest changer of the configuration*/
  if(config.size() > 0) { // If there is configuration history
	print config[0].getUserID() + "," + config[0].getUser() + ",";
  }
  else { // If there is no configuration history
	print "NA,NA,";
  }
  
  /*Get job status: whether the job is disabled or its last build is within ${DAYS} days*/
  if(it.isDisabled()) { // if it is disabled
	  println "Disabled";
  } else {
	 def lastbuild = it.getLastBuild(); // Get last build
	 if (lastbuild == null) { // If get NULL, there is no build history
		 println "No build History";
	 } else { // else, check with the last build is within ${DAYS} days;
		 def build_time = lastbuild.getTimestamp();
		 if(Calendar.instance.time.time/1000-build_time.time.time/1000 > INTERVAL) {
			 println ("Last build more than ${DAYS} days ago");
		 } else {
			 println ("Active within ${DAYS} days");
		 }
	 }
  }
}