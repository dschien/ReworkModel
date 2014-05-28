package rework.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import rework.ReLogoObserver;

class UserObserver extends ReLogoObserver{

	Queue easyJobs = [] as Queue
	Queue mediumJobs = [] as Queue
	Queue hardJobs = [] as Queue

	int reworkedJobs = 0
	
	@Setup
	def setup(){
		clearAll()

		def random = new Random()

		// init the jobs
		(0..numJobs).each{
			// random value between 100 and 200
			def effort  = random.nextInt(200-100+1)+100
			easyJobs << new Job(level:Level.EASY, effort: effort)
			mediumJobs << new Job(level:Level.MEDIUM, effort: effort)
			hardJobs << new Job(level:Level.HARD, effort: effort)
		}

		// create workers with random skills
		createWorkers ( numWorkers ){
			skill = Skill.getRandom()
		}
	}


	@Go
	def go(){
		ask(turtles()){ it ->
			// if this worker is free, give him a job
			if (!it.job){
				assignJob(it)
			}
			// let him work on it
			def job = step()
			// job completed?
			if (job && job.completion >= job.effort){
				// remove job from worker
				it.job = null
				// needs rework?
				if (new Random().nextInt(100) - (int)(reworkRate) < 0){
					reworkedJobs++
					job.completion = 0
					// reschedule job
					switch (job.level){
						case Level.EASY:
							easyJobs<< job
							break
						case Level.MEDIUM:
							mediumJobs<< job
							break
						case Level.HARD:
							hardJobs<< job
							break
						default:
							break
					}
				}
			}
		}
	}

	/**
	 * Get a job that is at maximum as hard as the skill of the worker
	 * @param worker
	 * @return
	 */
	def assignJob(worker){
		switch (worker.skill){
			case Skill.EXPERIENCED:
				worker.job = hardJobs.poll() ?: mediumJobs.poll() ?: easyJobs.poll() ?: null
				break
			case Skill.MEDIUM:
				worker.job = mediumJobs.poll() ?: easyJobs.poll() ?: null
				break
			case Skill.INEXPERIENCED:
				worker.job = easyJobs.poll() ?: null
			default:
				break
		}
	}
	
	def reworkedJobs(){
		return reworkedJobs
	}	
	
	/**
	 * Count remaining jobs
	 * @return
	 */
	def remainingJobs (){
		return easyJobs.size() + mediumJobs.size() + hardJobs.size()
	}
}