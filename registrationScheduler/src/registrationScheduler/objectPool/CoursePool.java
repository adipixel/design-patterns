package registrationScheduler.objectPool;

public class CoursePool extends Course{
		public static CoursePool uniqueCoursePool;
		static int busyFlag = 0;
		
	//constructor
		public CoursePool()
		{
			
		}
		
		public int addCourse()
		{
			return uniqueCoursePool.courseMap.get("A");
		}
		
		public static synchronized CoursePool borrowCoursePool()
		{
			if (busyFlag == 0)
			{
				if(uniqueCoursePool == null)
				{
					uniqueCoursePool = new CoursePool();
				}
				busyFlag = 1;
				return uniqueCoursePool;
			}
			else
			{
				return null;
			}
		}
		
		public static void returnCoursePool(CoursePool obj)
		{
			busyFlag = 0;
		}
		
		public void setFactory()
		{
			
		}
		
		public void clear()
		{
			
		}
		
		public void close()
		{
			
		}
		
		public int getNumActive()
		{
			return 1;
		}
		
		public int getNumIdle()
		{
			return 1;
		}
		
		public void invalidateCourse(Course obj)
		{
			
		}
}